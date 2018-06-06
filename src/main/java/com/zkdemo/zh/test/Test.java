package com.zkdemo.zh.test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Id;
import org.apache.zookeeper.server.auth.DigestAuthenticationProvider;

/**  
* Copyright (C), 2017, 银联智惠信息服务（上海）有限公司
* @author zhouhao 
* @version 2018年5月31日 上午10:25:53  zk新建节点
*/
public class Test {
    public static void main(String[] args) {
        List<ACL> acls = new ArrayList<ACL>(2);  
        try {  
            Id id1 = new Id("digest", DigestAuthenticationProvider.generateDigest("fish:fishpw"));  
            ACL acl1 = new ACL(ZooDefs.Perms.WRITE, id1);  
      
            Id id2 = new Id("digest", DigestAuthenticationProvider.generateDigest("qsd:qsdpw"));  
            ACL acl2 = new ACL(ZooDefs.Perms.READ, id2);  
      
            acls.add(acl1);  
            acls.add(acl2);  
        } catch (NoSuchAlgorithmException e1) {  
            e1.printStackTrace();  
        }  
      
        ZooKeeper zk = null;  
        try {  
            zk = new ZooKeeper("127.0.0.1:2181", 300000, new Watcher() {  
                // 监控所有被触发的事件  
                public void process(WatchedEvent event) {  
                    System.out.println("已经触发了" + event.getType() + "事件！");  
                }  
            });  
            if (zk.exists("/test", true) == null) {  
                System.out.println(zk.create("/test", "ACL测试".getBytes(), acls, CreateMode.PERSISTENT));  
            }  
        } catch (IOException e) {  
            e.printStackTrace();  
        } catch (KeeperException e1) {  
            e1.printStackTrace();  
        } catch (InterruptedException e1) {  
            e1.printStackTrace();  
        }  
    }

}
