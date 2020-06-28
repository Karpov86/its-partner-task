package by.karpov.ITSPartnertask.controller;

import by.karpov.ITSPartnertask.database.entity.Lamp;
import by.karpov.ITSPartnertask.database.entity.Room;
import by.karpov.ITSPartnertask.service.LampServiceImpl;
import by.karpov.ITSPartnertask.service.RoomServiceImpl;
import by.karpov.ITSPartnertask.util.GeoLocationService;
import by.karpov.ITSPartnertask.util.IpAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/room")
public class RoomController {

    private final RoomServiceImpl roomService;
    private final LampServiceImpl lampService;
    @Autowired
    private GeoLocationService geoLocationService;
    @Autowired
    private IpAddressService ipAddressService;

    @Autowired
    public RoomController(RoomServiceImpl roomService, LampServiceImpl lampService) {
        this.roomService = roomService;
        this.lampService = lampService;
    }

    @GetMapping
    public String roomView() {
        return "room";
    }

    @PostMapping("/save")
    public String saveRoom(
            @RequestParam String name,
            @RequestParam String country
    ) {
        roomService.save(new Room(name, country, new Lamp("off")));
        return "redirect:/room";
    }

    @GetMapping("/roomList")
    public String getAllRoom(Model model) {
        model.addAttribute("rooms", roomService.getAll());

        return "roomList";
    }

    @GetMapping("/{id}")
    public String getRoomById(
            @PathVariable Long id,
            Model model
    ) {
        Room room = roomService.findById(id);
        Lamp lamp = room.getLamp();
        model.addAttribute("lamp", lamp);
        return "roomById";
    }

    @PostMapping("/switch")
    public String lampSwitcher(
            @RequestParam Long id,
            @RequestParam String lampCondition
    ) {
        Lamp lamp = roomService.findById(id).getLamp();
        lampService.updateLampCondition(lamp, lampCondition);

        return "redirect:/room/" + id;
    }

}
