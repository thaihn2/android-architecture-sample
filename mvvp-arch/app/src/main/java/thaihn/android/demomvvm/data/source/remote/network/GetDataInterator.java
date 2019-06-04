package thaihn.android.demomvvm.data.source.remote.network;

import android.os.AsyncTask;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import thaihn.android.demomvvm.data.model.Repository;
import thaihn.android.demomvvm.data.source.RepoDataSource;

public class GetDataInterator {

    public static final String CHARSET_NAME_UTF8 = "UTF-8";
    public static final String METHOD_GET = "GET";
    public static final int CONNECTION_TIME_OUT = 5000;
    public static final int READ_INPUT_TIME_OUT = 5000;

    private static GetDataInterator sGetDataInterator;
    private RepoDataSource.OnFetchDataSource mOnFetchDataSource;

    public static GetDataInterator getInstance(RepoDataSource.OnFetchDataSource onFetchDataSource) {
        if (sGetDataInterator == null) {
            sGetDataInterator = new GetDataInterator(onFetchDataSource);
        }
        return sGetDataInterator;
    }

    public void loadData(String url) {
        new LoadRepo().execute(url);
    }

    private class LoadRepo extends AsyncTask<String, Void, List<Repository>> {

        @Override
        protected List<Repository> doInBackground(String... strings) {
            try {
                String result = getContentFromUrl(strings[0]);
                Type listType = new TypeToken<ArrayList<Repository>>() {
                }.getType();
                return new Gson().fromJson(result, listType);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(List<Repository> repositories) {
            super.onPostExecute(repositories);
            if (mOnFetchDataSource == null) return;
            if (repositories == null) {
                mOnFetchDataSource.onGetDataError("No data");
            } else {
                mOnFetchDataSource.onFetchDataSuccess(repositories);
            }
        }
    }

    /**
     * Get content string form URL
     *
     * @param strUrl
     * @return
     * @throws IOException
     */
    public String getContentFromUrl(String strUrl) throws IOException {
        String content = "";
        URL url = null;
        HttpURLConnection httpURLConnection = null;
        url = new URL(strUrl);
        httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod(METHOD_GET);
        httpURLConnection.setConnectTimeout(CONNECTION_TIME_OUT);
        httpURLConnection.setReadTimeout(READ_INPUT_TIME_OUT);
        httpURLConnection.setDoInput(true);
        httpURLConnection.connect();
        int responseCode = httpURLConnection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            content = parserResultFromContent(httpURLConnection.getInputStream());
        }
        return content;
    }

    /**
     * Parser result from input stream
     *
     * @param is
     * @return
     * @throws IOException
     */
    public String parserResultFromContent(InputStream is) throws IOException {
        String result = "";
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(is, CHARSET_NAME_UTF8));
        String line = "";
        while ((line = reader.readLine()) != null) {
            result += line;
        }
        is.close();
        return result;
    }

    private GetDataInterator(RepoDataSource.OnFetchDataSource onFetchDataSource) {
        this.mOnFetchDataSource = onFetchDataSource;
    }
}
