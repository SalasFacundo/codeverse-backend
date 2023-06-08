package com.codeverse.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codeverse.models.Inscription;

public interface IInscriptionRepository extends JpaRepository<Inscription, Long> {

}
