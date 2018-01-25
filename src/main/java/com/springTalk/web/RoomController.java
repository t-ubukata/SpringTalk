package com.springTalk.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.springTalk.domain.Message;
import com.springTalk.domain.Room;
import com.springTalk.domain.User;
import com.springTalk.service.MessageService;
import com.springTalk.service.RoomService;
import com.springTalk.service.UserService;

@Controller
public class RoomController {
  @Autowired
  private UserService userService;
  @Autowired
  private RoomService roomService;
  @Autowired
  private MessageService messageService;

  @GetMapping("/room/{roomId}")
  public String roomGet(Model model, @PathVariable Long roomId) {
    List<Message> messages = messageService.getMessagesByRoomIdOrderById(roomId);
    model.addAttribute("message", messages);
    model.addAttribute("roomForm", new RoomForm());
    return "room";
  }

  @PostMapping("/room/{roomId}")
  public String roomPost(Model model, @PathVariable Long roomId, @Valid RoomForm roomForm, BindingResult bindingResult,
      HttpServletRequest request) {
    if (bindingResult.hasErrors()) {
      List<Message> messages = messageService.getMessagesByRoomIdOrderById(roomId);
      model.addAttribute("message", messages);
      model.addAttribute("roomForm", new RoomForm());
      return "room";
    }
    // get dummy user
    // ToDo: get user id from request
    final Long SENDER_ID = 1L;
    User user = userService.getUserById(SENDER_ID).get(0);
    // ToDo: implement getRoomsById
    Room room = roomService.getRoomsById(roomId).get(0);
    messageService.save(new Message(user, room, roomForm.getText()));
    return "redirect:/room";
  }
}