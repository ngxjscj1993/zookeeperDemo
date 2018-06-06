package com.zkdemo.zh.test;

import java.io.IOException;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

/**  
* Copyright (C), 2017, 银联智惠信息服务（上海）有限公司
* @author zhouhao 
* @version 2018年5月31日 上午10:36:39  测试zk超级管理员权限
*/
public class Test2 {
    public static void main(String[] args) {
        try {  
            ZooKeeper zk = new ZooKeeper("127.0.0.1:2181", 300000, new Watcher() {  
                // 监控所有被触发的事件  
                public void process(WatchedEvent event) {  
                    System.out.println("已经触发了" + event.getType() + "事件！");  
                }  
            });  
            zk.addAuthInfo("digest", "super:superpw".getBytes());  
            System.out.println(new String(zk.getData("/test", null, null)));  
            zk.setData("/test", "I change！".getBytes(), -1);  
        } catch (KeeperException e) {  
            e.printStackTrace();  
        } catch (InterruptedException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        } 
    }

}
