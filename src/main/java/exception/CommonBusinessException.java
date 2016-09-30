package exception;

/**
 * 系统业务异常管理枚举类         格式参见SuccessAuctionBusinessException
 * @author 金砖
 *
 */
public enum CommonBusinessException {
	/**
	 * 日期转换异常
	 */
    DATE_PARSE_EXCEPTION("001"){
        public String getMessage() {
            return "日期转换错误！";
        }
    },
    /**
     * IO异常,数据读取错误
     */
    IO_EXCEPTION("003"){
        public String getMessage() {
            return "数据读写错误！";
        }
    },
    /**
     * http连接错误
     */
    HTTP_EXCEPTION("002"){
        @Override
        public String getMessage() {
            return "http连接错误";
        }
    },
    /**
     * 编码转换异常
     */
    UNSUPPORTED_ENCODING_EXCEPTION("004"){
        @Override
        public String getMessage() {
            return "URLDecoder错误!";
        }
    };
	 
	private CommonBusinessException(String code) {
        this.code = code;
    }
 
	private String code;
	
    public String getCode() {
        return code;
    }
 
    public String getMessage() {
        return "业务异常";
    }
    
    public static void main(String[] args) {
        System.out.println("CommonBusinessException.Test 的 code = " + CommonBusinessException.DATE_PARSE_EXCEPTION.getCode()+" \n "+CommonBusinessException.DATE_PARSE_EXCEPTION.getMessage());
    }
}
