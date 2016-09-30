package util;

public class CommonConstant {
    
    /**
     * 
     * @Description: 通话记录模块id
     * @author: simon.JY
     * @date: 2015年11月2日
     * 上海谨务汽车咨询技术有限公司
     */
    public static interface PhoneModule{
        /**
         * 成交邀约模块
         */
        public final static int BOSS_PHONE_MODULE_SUCCESS=1;
        /**
         * 拍场模块
         */
        public final static int BOSS_PHONE_MODULE_AUCTION=2;
        /**
         * 车辆检测模块
         */
        public final static int BOSS_PHONE_MODULE_CHECK=3;
        /**
         * 检测邀约模块
         */
        public final static int BOSS_PHONE_MODULE_INCREMENT=4;
        /**
         * 售后模块
         */
        public final static int BOSS_PHONE_MODULE_RECEPTION=5;
        
        /**
         * 售后模块更新业务表时间
         */
        public final static int BOSS_PHONE_MODULE_RECEPTION_UPDATETIME=6;

        /**
         *平安车商贷电话
         */
        public final static int BOSS_PHONE_MODULE_BUSINESS_VISIT=8;
    }
    
}
