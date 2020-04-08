package com.liuyewei.service;

import com.liuyewei.entity.Comment;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: liuyewei
 * Date: 2020/3/5
 * Time: 9:44 下午
 * Description:
 */
public interface CommentService {

    List<Comment> listCommentByBlogId(Long blogId);

    Comment saveComment(Comment comment);
}
