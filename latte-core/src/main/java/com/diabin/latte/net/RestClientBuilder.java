package com.diabin.latte.net;

import android.content.Context;

import com.diabin.latte.net.callback.IError;
import com.diabin.latte.net.callback.IFailure;
import com.diabin.latte.net.callback.IRequest;
import com.diabin.latte.net.callback.ISuccess;
import com.diabin.latte.ui.LoaderStyle;


import java.io.File;
import java.util.Map;
import java.util.WeakHashMap;

import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * Created by Administrator on 2017/11/3 0003
 * function:
 */

public class RestClientBuilder {//Builder传值的操作，建造者模式不能是final修饰，final不能一次性赋值
    private  String mUrl=null;
    private  static final WeakHashMap<String,Object> PARAMS=RestCreator.getParams();
    private  IRequest mIRequest=null;
    private  ISuccess mISuccess=null;
    private  IFailure mIFailure=null;
    private  IError mIError=null;
    private  RequestBody mBody=null;
    private Context mContext=null;
    private LoaderStyle mLoaderStyle=null;
    private File mFile=null;

    private String mDownloadDir=null;
    private String mExtension=null;
    private String mName=null;

    RestClientBuilder(){
    }

    public final RestClientBuilder url(String url){
        this.mUrl=url;
        return this;
    }

    public final RestClientBuilder params(WeakHashMap<String,Object> params){
        PARAMS.putAll(params);
        return this;
    }

    public final RestClientBuilder file(File file){
        this.mFile=file;
        return this;
    }

    public final RestClientBuilder dir(String dir){
        this.mDownloadDir=dir;
        return this;
    }

    public final RestClientBuilder extension(String extension){
        this.mExtension=extension;
        return this;
    }

    public final RestClientBuilder name(String name){
        this.mName=name;
        return this;
    }

    public final RestClientBuilder file(String file){
        this.mFile=new File(file);
        return this;
    }

    public final RestClientBuilder params(String key,Object value){
        PARAMS.put(key,value);
        return this;
    }

    public final RestClientBuilder raw(String raw){
        this.mBody= RequestBody.create(MediaType.parse("application/json;charset=UTF-8"),raw);
        return this;
    }

    public final RestClientBuilder onRequest(IRequest iRequest){
        this.mIRequest=iRequest;
        return this;
    }

    public final RestClientBuilder success(ISuccess iSuccess){
        this.mISuccess=iSuccess;
        return this;
    }

    public final RestClientBuilder failure(IFailure iFailure){
        this.mIFailure=iFailure;
        return this;
    }

    public final RestClientBuilder error(IError iError){
        this.mIError=iError;
        return this;
    }

//    private Map<String,Object> checkParams(){
//        if (mParams==null){
//            return new WeakHashMap<>();
//        }
//        return mParams;
//    }

    public final RestClientBuilder loader(Context context,LoaderStyle loaderStyle){
        this.mContext=context;
        this.mLoaderStyle=loaderStyle;
        return this;
    }

    public final RestClientBuilder loader(Context context){
        this.mContext=context;
        this.mLoaderStyle=LoaderStyle.BallClipRotatePulseIndicator;
        return this;
    }

    public final RestClient build(){
        return new RestClient(mUrl,PARAMS,mDownloadDir,
                mExtension,mName,mIRequest,mISuccess,
                mIFailure,mIError,mBody,mFile,mContext,
                mLoaderStyle);
    }
}
