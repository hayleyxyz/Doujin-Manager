package server;

/**
 * Created by Oscar on 18/01/2015.
 */
public class Response {

    protected int code;
    protected String content;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public static Response make(int code, String content) {
        Response response = new Response();
        response.setCode(code);
        response.setContent(content);

        return response;
    }

    public static Response make(int code) {
        return make(code, null);
    }

}
