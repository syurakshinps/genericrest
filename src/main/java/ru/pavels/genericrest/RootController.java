package ru.pavels.genericrest;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.pavels.genericrest.model.MyModel;

@RestController
@RequestMapping("/api/all")
public class RootController {

    // GET method stub
    @GetMapping
    public String getAllMovies() {
        return "Getting all movies...";
    }

    @PostMapping("/mymodel")
    public ResponseEntity<MyModel> createMyModel(@RequestBody MyModel myModel) {
        if (myModel.getId() == (long) 0) {
            myModel.setDescription("id was 0");
        } else {
            if (myModel.getId() % 2 == 0) {
                myModel.setId((long) (myModel.getId() * 2));
                myModel.setDescription("id = id * 2");
            } else {
                myModel.setId((long) (myModel.getId() * 3));
                myModel.setDescription("id = id * 3");
            }
        }
        return ResponseEntity.ok(myModel);
    }



    // PUT method stub
    @PutMapping("/{id}")
    public String updateMovie(@PathVariable Long id) {
        return "Updating movie with ID: " + id;
    }

    // DELETE method stub
    @DeleteMapping("/{id}")
    public String deleteMovie(@PathVariable Long id) {
        return "Deleting movie with ID: " + id;
    }

    // PATCH method stub
    @PatchMapping("/{id}")
    public String partiallyUpdateMovie(@PathVariable Long id) {
        return "Partially updating movie with ID: " + id;
    }
}

