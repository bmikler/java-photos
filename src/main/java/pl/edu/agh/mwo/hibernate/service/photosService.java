package pl.edu.agh.mwo.hibernate.service;

import pl.edu.agh.mwo.hibernate.repository.HibernateRepository;

public class photosService {

    private final HibernateRepository hibernateUserRepository;

    public photosService(HibernateRepository hibernateUserRepository) {
        this.hibernateUserRepository = hibernateUserRepository;
    }
}
