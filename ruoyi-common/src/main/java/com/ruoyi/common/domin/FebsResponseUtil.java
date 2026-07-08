package com.ruoyi.common.domin;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ruoyi.common.domin.FebsResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FebsResponseUtil {
    /**
     * 返回成功
     * @param data  返回值
     * @return
     */
    public static FebsResponse success(Object data){


        return new FebsResponse().status(FebsResponse.SUCCESS_STATUS).message("成功").data(data);
    }

    /**
     * 返回成功
     * @param message  返回值
     * @return
     */
    public static FebsResponse success(String message){


        return new FebsResponse().status(FebsResponse.SUCCESS_STATUS).message(message).data(null);
    }

    /**
     * 返回成功
     * @param message   提示消息
     * @param data  返回值
     * @return
     */
    public static FebsResponse success(String message, Object data){


        return new FebsResponse().status(FebsResponse.SUCCESS_STATUS).message(message).data(data);
    }

    /**
     * 新增成功
     * @return
     */
    public static FebsResponse addSuccess(){


        return new FebsResponse().status(FebsResponse.SUCCESS_STATUS).message("新增成功").data(null);
    }
    /**
     * 修改成功
     * @return
     */
    public static FebsResponse updateSuccess(){


        return new FebsResponse().status(FebsResponse.SUCCESS_STATUS).message("修改成功").data(null);
    }
    /**
     * 删除成功
     * @return
     */
    public static FebsResponse deleteSuccess(){


        return new FebsResponse().status(FebsResponse.SUCCESS_STATUS).message("删除成功").data(null);
    }
    /**
     * 返回失败
     * @param status  状态
     * @return
     */
    public static FebsResponse error(String status){


        return new FebsResponse().status(status).message("失败").data(null);
    }

    /**
     * 返回失败
     * @param status  状态
     * @param message  提示消息
     * @return
     */
    public static FebsResponse error(String status, String message){


        return new FebsResponse().status(status).message(message).data(null);
    }

    public static FebsResponse pageList(IPage pageInfo) {


        if (pageInfo == null){


            return new FebsResponse().status("2000").message("查询失败，请联系管理员").data(null);
        }
        Map<String, Object> rspData = new HashMap<>();
        rspData.put("rows", pageInfo.getRecords());
        rspData.put("total", pageInfo.getTotal());
        rspData.put("current", pageInfo.getCurrent());
        rspData.put("pages", pageInfo.getPages());
        rspData.put("size", pageInfo.getSize());
        return new FebsResponse().status(FebsResponse.SUCCESS_STATUS).message("查询成功").data(rspData);
    }

    public static FebsResponse responseBean(Object object){


        if(object!=null){


            return  new FebsResponse().status(FebsResponse.SUCCESS_STATUS).message("操作成功").data(object);
        }else {


            return  new FebsResponse().status("2000").message("对象为空").data(null);
        }
    }

    public static FebsResponse responseList(List list){


        if(list!=null){


            return  new FebsResponse().status(FebsResponse.SUCCESS_STATUS).message("操作成功").data(list);
        }else {


            return  new FebsResponse().status("2000").message("查询失败").data(new ArrayList<>());
        }
    }

    /**
     * 失败
     * @param message
     * @return
     */
    public static FebsResponse fail(String message) {


        return new FebsResponse().status(FebsResponse.FAIL_STATUS).message(message).data(null);
    }
}
