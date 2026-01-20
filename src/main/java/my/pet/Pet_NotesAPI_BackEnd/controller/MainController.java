package my.pet.Pet_NotesAPI_BackEnd.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@Tag(
        name = "Root",
        description = "Корневой контролер сервера предназначен для оценки работоспособности непосредственно приложения, " +
                "включающего в себя группу API ресурсов"
)
@RestController
@RequestMapping({"/", ""})
public class MainController implements InformationController{

   // @GetMapping
   // public RedirectView redirectToRoot() {
      //  RedirectView redirectView = new RedirectView();
       // redirectView.setUrl("/swagger-ui.html");
   //     return redirectView;
  //  }


}
