package com.codeclan.example.filofax.components;

import com.codeclan.example.filofax.models.File;
import com.codeclan.example.filofax.models.Folder;
import com.codeclan.example.filofax.models.User;
import com.codeclan.example.filofax.repositories.FileRepository;
import com.codeclan.example.filofax.repositories.FolderRepository;
import com.codeclan.example.filofax.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

public class DataLoader implements ApplicationRunner {

    @Autowired
    FileRepository fileRepository;

    @Autowired
    FolderRepository folderRepository;

    @Autowired
    UserRepository userRepository;

    public DataLoader(){
    }

    public void run(ApplicationArguments args){
        User user1 = new User("Rhiannon");
        userRepository.save(user1);
        User user2 = new User("Mario");
        userRepository.save(user2);
        User user3 = new User("Luigi");
        userRepository.save(user3);

        Folder folder1 = new Folder("TUNES", user1);
        folderRepository.save(folder1);
        Folder folder2 = new Folder("BELTERS", user2);
        folderRepository.save(folder2);
        Folder folder3 = new Folder("PICCYS", user3);
        folderRepository.save(folder3);

        File file1 = new File("Tune", "mp4", 600, folder1);
        fileRepository.save(file1);
        File file2 = new File("Pic", "jpg", 800, folder2);
        fileRepository.save(file2);
        File file3 = new File("Belter", "mp4", 1000, folder3);
        fileRepository.save(file3);



    }


}
