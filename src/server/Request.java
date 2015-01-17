package server;

import java.util.Map;

/**
 * Created by Oscar on 17/01/2015.
 */
public class Request {

    protected String method;
    protected String path;
    protected Map<String, String> headers;
    protected Map<String, String> params;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

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

    public Map<String, String> getParams() {
        return params;
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }

    public void dump() {
        System.out.println(this.method + " " + this.path);

        for (Map.Entry<String, String> header : this.headers.entrySet()) {
            System.out.println(header.getKey() + ": " + header.getValue());
        }

        if(this.params.size() > 0) {
            System.out.println("Params:");

            for (Map.Entry<String, String> param : this.params.entrySet()) {
                System.out.println("\t" + param.getKey() + "=" + param.getValue());
            }
        }

        System.out.println();
    }
}
