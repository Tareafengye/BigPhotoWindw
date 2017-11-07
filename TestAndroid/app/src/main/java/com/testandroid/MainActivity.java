package com.testandroid;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.baoyz.actionsheet.ActionSheet;
import com.photolibrary.photo.controller.PhotoPickConfig;
import com.photolibrary.photo.controller.PhotoPreviewConfig;
import com.photolibrary.photo.util.MeiUtilPhotoUtil;

import java.io.File;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button btnPckphoto, btnViewBigPicture;
    private Activity context;
    private ArrayList<String> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;

        btnPckphoto = (Button) findViewById(R.id.btnPckphoto);
        btnViewBigPicture = (Button) findViewById(R.id.btnViewBigPicture);
        btnPckphoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActionSheet();
            }
        });
        btnViewBigPicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getBig();

            }
        });
    }

    public void getBig() {
        for (int i = 0; i < ImageUrls.getImages().size(); i++) {
            list.add(ImageUrls.getImages().get(i) + "");
        }
        MeiUtilPhotoUtil.setNetWorkBigPicture(this, list, 0);
    }

    public void getActionSheet() {
        ActionSheet.createBuilder(context, getSupportFragmentManager())
                .setCancelButtonTitle("取消")
                .setOtherButtonTitles("打开相册", "拍照", "观看视频")
                .setCancelableOnTouchOutside(true)
                .setListener(new ActionSheet.ActionSheetListener() {
                    @Override
                    public void onDismiss(ActionSheet actionSheet, boolean isCancel) {
                    }

                    @Override
                    public void onOtherButtonClick(ActionSheet actionSheet, int index) {
                        if (index == 0) {
                            Toast.makeText(context, "相册", Toast.LENGTH_LONG).show();
                        } else if (index == 1) {
                            Toast.makeText(context, "拍照", Toast.LENGTH_LONG).show();
//                            MeiUtilPhotoUtil.onPhotoHead(context);
                        } else if (index == 2) {
                            Toast.makeText(context, "视频", Toast.LENGTH_LONG).show();

                        }

                    }
                })
                .show();
    }

    //选择相册拍照回调地址
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != Activity.RESULT_OK || data == null) {
            return;
        }
        switch (requestCode) {
            case PhotoPickConfig.PICK_REQUEST_CODE://图片
                ArrayList<String> photoLists = data.getStringArrayListExtra(PhotoPickConfig.EXTRA_STRING_ARRAYLIST);
                //用户选择的是否是原图
                boolean isOriginalPicture = data.getBooleanExtra(PhotoPreviewConfig.EXTRA_ORIGINAL_PIC,false);
                if (photoLists != null && !photoLists.isEmpty()) {
                    Log.i("MainActivity","selected photos = " + photoLists.toString());
                    Toast.makeText(this,"selected photos size = " + photoLists.size() + "\n" + photoLists.toString(),Toast.LENGTH_LONG).show();
                    File file = new File(photoLists.get(0));
                    if (file.exists()) {
                        //you can do something

                    } else {
                        //toast error

                    }
                }
                break;
        }
    }
}
