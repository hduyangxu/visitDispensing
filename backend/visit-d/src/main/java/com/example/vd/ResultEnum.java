package com.example.vd;

public enum ResultEnum {
    SUCCESS(200, "请求成功"),
    FIELD(400, "请求失败"),
    NO_PERMISSION(403, "请求被拒绝");

    private final Integer code;
    private final String msg;

    private ResultEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    public static String getMessageByCode(Integer code) {
        ResultEnum[] var1 = values();
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            ResultEnum ele = var1[var3];
            if (ele.getCode().equals(code)) {
                return ele.getMsg();
            }
        }

        return null;
    }
}
