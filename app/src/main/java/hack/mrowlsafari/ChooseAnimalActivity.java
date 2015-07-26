package hack.mrowlsafari;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;


public class ChooseAnimalActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_choose_animal);
		ImageView imageView = (ImageView) findViewById(R.id.picView);
		imageView.setImageResource(R.mipmap.rabbit);

		((ImageView) findViewById(R.id.chooseView1)).setImageResource(R.mipmap.elephant);
		((ImageView) findViewById(R.id.chooseView2)).setImageResource(R.mipmap.horse);
		((ImageView) findViewById(R.id.chooseView3)).setImageResource(R.mipmap.seal);
		((ImageView) findViewById(R.id.chooseView4)).setImageResource(R.mipmap.gopher);
		((ImageView) findViewById(R.id.chooseView6)).setImageResource(R.mipmap.mouse);
		((ImageView) findViewById(R.id.chooseView7)).setImageResource(R.mipmap.sheepir);

		imageView = (ImageView) findViewById(R.id.chooseView5);
		imageView.setImageResource(R.mipmap.rabbit);

		final Activity that = this;
		imageView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
					startActivity(new Intent(that, MainActivity.class));
			}
		});

	}

}
