package hack.mrowlsafari;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.flir.flironesdk.Device;
import com.flir.flironesdk.Frame;
import com.flir.flironesdk.FrameProcessor;
import com.flir.flironesdk.RenderedImage;

import java.util.EnumSet;


public class CaptureActivity extends Activity implements Device.Delegate, Device.StreamDelegate, FrameProcessor.Delegate {
	private FrameProcessor mProcessor;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_capture);

		RenderedImage.ImageType blendedType = RenderedImage.ImageType.BlendedMSXRGBA8888Image;
		mProcessor = new FrameProcessor(this, this, EnumSet.of(blendedType));
		mProcessor.setImagePalette(RenderedImage.Palette.Iron);
	}

	@Override
	protected void onResume() {
		super.onResume();
		Device.startDiscovery(this, this);
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

	}
}
