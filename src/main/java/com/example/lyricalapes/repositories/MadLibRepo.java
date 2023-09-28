package com.gptlibs.fullstackgptlibs.repositories;

import com.gptlibs.fullstackgptlibs.models.MadLib;
import com.gptlibs.fullstackgptlibs.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MadLibRepo extends JpaRepository<MadLib, Long> {
    List<MadLib> findMadLibByUser(User loggedInUser);
}
