package com.heiyu.blog.service;

import com.heiyu.blog.domain.Node;
import com.heiyu.blog.repository.NodeRepository;
import com.heiyu.blog.repository.PublicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @ClassName NodeService
 * @Description TODO
 * @Author Jayfeather
 * @Date 2019/2/1 1:00
 * @Version 1.0
 **/
@Service
public class NodeService {

    @Autowired
    private NodeRepository nodeRepository;

    @Autowired
    private PublicRepository publicRepository;

    public String noderead(int pageSize,int pageNum){
        List<Node> nodes = nodeRepository.readNodeList(pageSize,pageNum);
        String nodeListStr = "";
        if (nodes!= null){
            for(Node node:nodes){
                node=(Node)node;
                nodeListStr+= node.toString();

            }return nodeListStr;
        }else{
                return null;
        }
    }


    public boolean nodeWrite(Node node){
        node.setId(publicRepository.getMaxID("article_node","node_id")+1);
        node.setUpdateTime(new Date());
        node.setCreatTime(new Date());
        return nodeRepository.writeNode(node);
    }


    public boolean nodeDelete(Node node){
        node.setUpdateTime(new Date());
        node.setRemove(true);
        return nodeRepository.deleteNode(node);
    }

    public boolean nodeUpdate(Node node){
        node.setUpdateTime(new Date());
        return nodeRepository.updateNode(node);
    }
}

