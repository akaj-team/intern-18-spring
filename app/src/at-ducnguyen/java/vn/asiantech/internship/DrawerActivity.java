package vn.asiantech.internship;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

import vn.asiantech.internship.model.BodyDrawer;
import vn.asiantech.internship.model.HeaderDrawer;

public class DrawerActivity extends AppCompatActivity implements OnChangeAvatarListener {
    public static final int REQUEST_GALERY = 0;
    public static final int REQUEST_CAMERA = 1;
    private HeaderDrawer mHeaderDrawer;
    private DrawerLayoutAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);

        List<BodyDrawer> listItemBody = new ArrayList<>();
        listItemBody.add(new BodyDrawer(R.drawable.ic_move_to_inbox_black_24dp, R.string.inbox));
        listItemBody.add(new BodyDrawer(R.drawable.ic_send_black_24dp, R.string.outbox));
        listItemBody.add(new BodyDrawer(R.drawable.ic_delete_black_24dp, R.string.trash));
        listItemBody.add(new BodyDrawer(R.drawable.ic_report_black_24dp, R.string.spam));

        mHeaderDrawer = new HeaderDrawer();

        mAdapter = new DrawerLayoutAdapter(this, listItemBody, mHeaderDrawer);
        mAdapter.setOnChangeAvatarListener(this);

        final RecyclerView recyclerViewInformation = findViewById(R.id.recyclerViewInformation);
        recyclerViewInformation.setAdapter(mAdapter);
        recyclerViewInformation.setLayoutManager(new LinearLayoutManager(DrawerActivity.this));

        DrawerLayout drawerLayout = findViewById(R.id.drawerLayout);
        drawerLayout.setScrimColor(Color.TRANSPARENT);

        final RelativeLayout rlContent = findViewById(R.id.rlContent);

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(
                this, drawerLayout, R.string.draw_desc_open, R.string.drawer_desc_close) {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
                float slideX = drawerView.getWidth() * slideOffset;
                rlContent.setTranslationX(slideX);
            }
        };
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Uri uri;
        switch (requestCode) {
            case REQUEST_GALERY: {
                uri = data.getData();
                mHeaderDrawer.setAvatar(uri);
                mAdapter.notifyDataSetChanged();
                break;
            }
            case REQUEST_CAMERA: {
                Bitmap photo;
                if (data.getExtras() != null) {
                    photo = (Bitmap) data.getExtras().get("data");
                    uri = getImageUri(getApplicationContext(), photo);
                    mHeaderDrawer.setAvatar(uri);
                    mAdapter.notifyDataSetChanged();
                }
                break;
            }

        }
    }


    @Override
    public void onChooseFromGalery() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(intent, REQUEST_GALERY);
    }

    @Override
    public void onTakeANewPhoto() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, DrawerActivity.REQUEST_CAMERA);
        }
    }

    public Uri getImageUri(Context inContext, Bitmap inImage) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        inImage.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
        String path = MediaStore.Images.Media.insertImage(inContext.getContentResolver(), inImage, "Title", null);
        return Uri.parse(path);
    }
}
