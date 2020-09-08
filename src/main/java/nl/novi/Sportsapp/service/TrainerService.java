package nl.novi.Sportsapp.service;


//serviceklasse communiceert met de CRUD repositories
// en krijgt de verantwoordelijkheid om wat er in de repository/persistencelaag
// om dat vervolgens in de database toe te voegen.

import nl.novi.Sportsapp.model.Activity;
import nl.novi.Sportsapp.model.Trainer;
import nl.novi.Sportsapp.repository.ActivityRepository;
import nl.novi.Sportsapp.repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrainerService {

    @Autowired
    private TrainerRepository trainerRepository;


    public Trainer getTrainerById(long trainerId){
        Optional<Trainer> trainer = trainerRepository.findById(trainerId);
        if (trainer.isPresent()){
            return trainer.get();
        }
//        throw new TrainerNotFoundException("");
        return null;
//        return trainerRepository.findById(trainerId).orElseThrow(
//                () -> new TrainerNotFoundException(trainerId));
    }






    public boolean deleteTrainerById(long trainerId){
        Optional<Trainer> trainer = trainerRepository.findById(trainerId);
        if (trainer.isPresent()) {
            trainerRepository.deleteById(trainerId);
            return true;
        }
        return false;
    }

}
