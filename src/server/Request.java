package server;

import java.util.Map;

/**
 * Created by Oscar on 17/01/2015.
 */
public class Request {

    protected String method;
    protected String path;
    protected Map<String, String> headers;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }
}
