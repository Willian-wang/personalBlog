package com.heiyu.blog.controller;

import com.heiyu.blog.domain.Node;
import com.heiyu.blog.service.NodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

import static com.heiyu.blog.controller.StatusCode.*;
import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * @ClassName NodeController
 * @Description TODO
 * @Author Jayfeather
 * @Date 2019/2/1 23:43
 * @Version 1.0
 **/

@RestController
public class NodeController{

    @Autowired
    private NodeService nodeService;

    @RequestMapping(value = "/node/{pageNum}/{pageSize}",method = GET)
    public String readNode(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize , HttpServletResponse httpServletResponse){
        String json = nodeService.noderead(pageSize,pageNum);
        if(json ==null){
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return SERVERERROW;
        }else if(json == ""){
            httpServletResponse.setStatus(HttpServletResponse.SC_GATEWAY_TIMEOUT);
            return NOTFOUND;
        }else {
            return json;
        }
    }

    @RequestMapping(value = "/admin/node" , method = POST)
    public String writeNode(@RequestBody Node node){
        boolean isSuccess = nodeService.nodeWrite(node);
        if(isSuccess){
            return SUCCESS;
        }else {
            return SERVERERROW;
        }
    }

    @RequestMapping(value = "admin/node/{id}",method = DELETE)
    public String deletNode(@PathVariable("id") int id){
        Node node = new Node();
        node.setId(id);
        boolean isSuccess = nodeService.nodeDelete(node);
        if(isSuccess){
            return SUCCESS;
        }else {
            return SERVERERROW;
        }
    }

    @RequestMapping(value = "/admin/node/{id}",method = PUT)
    public String UpdateNode(@PathVariable("id") int id){
        Node node = new Node();
        node.setId(id);
        boolean isSuccess = nodeService.nodeUpdate(node);
        if(isSuccess){
            return SUCCESS;
        }else {
            return SERVERERROW;
        }
    }
}
