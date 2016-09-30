package util;

public class ResultJson {

    private String code = "200";
    private String message = "";
    private String result = "{}";

    public static ResultJson getInstall() {
        return new ResultJson();
    }

    public ResultJson() {
        this.code = "200";
        this.message = "";
        this.result = "{}";
    }

    public ResultJson(String code, String result) {
        this.code = code;
        this.message = "";
        this.result = result;
    }

    public ResultJson(String code, String message, String result) {
        this.code = code;
        this.message = message;
        this.result = (result == null || "".equals(result)) ? "\"\"" : result;
    }

    public ResultJson(String code) {
        this.code = code;
        this.message = "";
        this.result = "";
    }

    public String getCode() {
        return code;
    }

    public ResultJson setCode(String code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public ResultJson setMessage(String message) {
        this.message = message;
        return this;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        if ("".equals(result)) {
            this.result = "\"\"";
        } else {
            this.result = result;
        }
    }

    public String toString() {
        return "{\"code\":\"" + this.code + "\",\"message\":\"" + this.message + "\",\"result\":" + this.result + "}";
    }
}
