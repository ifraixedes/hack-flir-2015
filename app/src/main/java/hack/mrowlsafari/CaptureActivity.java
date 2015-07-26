package hack.mrowlsafari;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.flir.flironesdk.Device;
import com.flir.flironesdk.Frame;
import com.flir.flironesdk.FrameProcessor;
import com.flir.flironesdk.RenderedImage;

import java.nio.ByteBuffer;
import java.util.EnumSet;


public class CaptureActivity extends Activity implements Device.Delegate, Device.StreamDelegate, FrameProcessor.Delegate {
	private FrameProcessor mProcessor;
	private ImageView thermalImageView;
	private Bitmap thermalBitmap;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_capture);

		thermalImageView = (ImageView) findViewById(R.id.thermalView);

		RenderedImage.ImageType blendedType = RenderedImage.ImageType.BlendedMSXRGBA8888Image;
		mProcessor = new FrameProcessor(this, this, EnumSet.of(blendedType));
		mProcessor.setImagePalette(RenderedImage.Palette.Iron);

	}

	@Override
	protected void onResume() {
		super.onResume();
		try {
			Device.startDiscovery(this, this);
		}catch(IllegalStateException e) {
			// it's okay if we've already started discovery
		}
	}

	@Override
	protected void onPause() {
		super.onPause();
		Device.stopDiscovery();
	}

	@Override
	public void onTuningStateChanged(Device.TuningState tuningState) {

	}

	@Override
	public void onAutomaticTuningChanged(boolean b) {

	}

	@Override
	public void onDeviceConnected(Device device) {
		device.startFrameStream(this);
	}

	@Override
	public void onDeviceDisconnected(Device device) {

	}

	@Override
	public void onFrameReceived(Frame frame) {
		mProcessor.processFrame(frame);
	}

	@Override
	public void onFrameProcessed(RenderedImage renderedImage) {
		if (this.thermalBitmap == null
			|| (renderedImage.width() != thermalBitmap.getWidth()
			|| renderedImage.height() != thermalBitmap.getHeight())) {
			thermalBitmap = Bitmap.createBitmap(renderedImage.width(), renderedImage.height(), Bitmap.Config.ARGB_8888);
			thermalBitmap.copyPixelsToBuffer(ByteBuffer.wrap(renderedImage.pixelData()));
			runOnUiThread(new Runnable() {
				@Override
				public void run() {
					thermalImageView.setImageBitmap(thermalBitmap);
				}
			});
		}
	}
}
