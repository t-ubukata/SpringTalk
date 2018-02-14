package com.springTalk.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.springTalk.domain.Message;
import com.springTalk.domain.Room;
import com.springTalk.domain.User;
import com.springTalk.service.MessageService;
import com.springTalk.service.RoomService;
import com.springTalk.service.UserService;

@Controller
public class RoomsController {
  @Autowired
  private UserService userService;
  @Autowired
  private RoomService roomService;
  @Autowired
  private MessageService messageService;

  @GetMapping("/rooms")
  public String roomsGet(Model model) {
    List<Message> messages = messageService.getFirstMessageOfRoomOrderByIdDesc();
    model.addAttribute("messages", messages);
    model.addAttribute("roomsForm", new RoomsForm());

    // List<Room> rooms = roomService.getRoomsOrderByIdDesc();
    // model.addAttribute("rooms", rooms);
    // model.addAttribute("roomsForm", new RoomsForm());

    return "rooms";
  }

  @PostMapping("/rooms")
  public String roomsPost(Model model, @Valid RoomsForm roomsForm, BindingResult bindingResult,
      HttpServletRequest request) {
    if (bindingResult.hasErrors()) {
      List<Message> messages = messageService.getFirstMessageOfRoomOrderByIdDesc();
      model.addAttribute("messages", messages);
      model.addAttribute("roomsForm", new RoomsForm());

      // List<Room> rooms = roomService.getRoomsOrderByIdDesc();
      // model.addAttribute("rooms", rooms);
      // model.addAttribute("roomsForm", new RoomsForm());

      return "rooms";
    }

    // get dummy user
    // ToDo: get user id from request
    final Long OWNER_ID = 1L;
    User user = userService.getUserById(OWNER_ID).get(0);
    Room room = roomService.saveAndFlush(new Room(user));
    messageService.save(new Message(user, room, roomsForm.getText()));
    return "redirect:/rooms";
  }
}