package com.sina.weibo.sdk.openapi;

import android.content.Context;
import android.util.SparseArray;

import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.net.RequestListener;
import com.sina.weibo.sdk.net.WeiboParameters;

public class EmotionsAPI extends AbsOpenAPI {
	/** API URL */
	private static final String API_BASE_URL = API_SERVER;

	private static final int READ_API_EMOTIONS = 0;

	private static final SparseArray<String> sAPIList = new SparseArray<String>();
	static {
		sAPIList.put(READ_API_EMOTIONS, API_BASE_URL + "/emotions.json");
	}

	public EmotionsAPI(Context context, String appKey,
			Oauth2AccessToken accessToken) {
		super(context, appKey, accessToken);
	}

	/**
	 * 获取官方表情包
	 * 
	 * @param type
	 *            表情类别，face：普通表情、ani：魔法表情、cartoon：动漫表情，默认为face。
	 * @param language
	 *            false string 语言类别，cnname：简体、twname：繁体，默认为cnname。
	 * @param listener
	 *            异步请求回调接口
	 */
	public void readEmotions(String type, String language,
			RequestListener listener) {
		WeiboParameters params = new WeiboParameters(mAppKey);
		params.put("type", type);
		params.put("language", language);
		requestAsync(sAPIList.get(READ_API_EMOTIONS), params, HTTPMETHOD_GET,
				listener);
	}

}
