package jomrepspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jomrepspring.domain.Cupon;


@Repository
public interface CuponRepository extends JpaRepository<Cupon, Long>{

}