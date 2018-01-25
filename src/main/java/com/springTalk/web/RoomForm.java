package com.springTalk.web;

import javax.validation.constraints.Size;

public class RoomForm {
  @Size(min = 1, max = 256)
  private String text;

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }
}