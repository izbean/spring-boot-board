package com.board.domain.post.dto.request;

import javax.validation.constraints.NotNull;

public class PostCommentRequest {

    @NotNull
    private Long boardContentsId;

    private String comment;

}
