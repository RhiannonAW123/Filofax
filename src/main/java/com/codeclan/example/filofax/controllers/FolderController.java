import com.codeclan.example.filofax.models.Folder;
import com.codeclan.example.filofax.repositories.FolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class FolderController {

    @Autowired
    FolderRepository folderRepository;

    @GetMapping(value = "/folders")
    public ResponseEntity <List<FolderRepository>> getAllFolders(){
        return  new ResponseEntity(folderRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/folders/{id}")
    public ResponseEntity<FolderRepository> getFolder(@PathVariable Long id){
        return new ResponseEntity(folderRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/folders")
    public ResponseEntity<FolderRepository> postFolder(@RequestBody Folder folder) {
        folderRepository.save(folder);
        return new ResponseEntity(folder, HttpStatus.CREATED);
    }
}
