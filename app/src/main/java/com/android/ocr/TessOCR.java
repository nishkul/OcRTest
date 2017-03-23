package com.android.ocr;

import java.io.File;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.os.Environment;

import com.googlecode.tesseract.android.TessBaseAPI;

public class TessOCR {
	private TessBaseAPI mTess;
	
	public TessOCR() {

//
//		final AssetManager assetManager = getAssets();
//		try {
//			// for assets folder add empty string
//			String[] filelist = assetManager.list("");
//			// for assets/subFolderInAssets add only subfolder name
//			String[] filelistInSubfolder = assetManager.list("subFolderInAssets");
//			if (filelist == null) {
//				// dir does not exist or is not a directory
//			} else {
//				for (int i=0; i<filelist.length; i++) {
//					// Get filename of file or directory
//					String filename = filelist[i];
//				}
//			}
//
//			// if(filelistInSubfolder == null) ............
//
//		} catch (IOException e) {
//			e.printStackTrace();
//		}

		String sAssets = "file:///android_asset/" + "tessdata/eng.traineddata";

		// TODO Auto-generated constructor stub
		mTess = new TessBaseAPI();
		String datapath = Environment.getExternalStorageDirectory() + "/tesseract/";
		String language = "eng";
		File dir = new File(datapath + "tessdata/");
		if (!dir.exists()) 
			dir.mkdirs();
		mTess.init(datapath, language);
	}
	
	public String getOCRResult(Bitmap bitmap) {
		
		mTess.setImage(bitmap);
		String result = mTess.getUTF8Text();

		return result;
    }
	
	public void onDestroy() {
		if (mTess != null)
			mTess.end();
	}
	
}
