package com.controller;

import com.model.Comment;
import com.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    @Autowired
    private CommentRepository commentRepository;

    @GetMapping
    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    @GetMapping("/{id}")
    public Comment getCommentById(@PathVariable int id) {
        return commentRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Comment createComment(@RequestBody Comment comment) {
        return commentRepository.save(comment);
    }

    @PutMapping("/{id}")
    public Comment updateComment(@PathVariable int id, @RequestBody Comment comment) {
        if (commentRepository.existsById(id)) {
            comment.setCommentID(id);
            return commentRepository.save(comment);
        } else {
            return null; // Or handle as needed
        }
    }

    @DeleteMapping("/{id}")
    public void deleteComment(@PathVariable int id) {
        commentRepository.deleteById(id);
    }
}
