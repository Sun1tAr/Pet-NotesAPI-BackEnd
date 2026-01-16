package my.pet.Pet_NotesAPI_BackEnd.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(
        name = "Root",
        description = "Корневой контролер сервера предназначен для оценки работоспособности непосредственно приложения, " +
                "включающего в себя группу API ресурсов"
)
@RestController
@RequestMapping({"/", ""})
public class MainController implements InformationController{


}
