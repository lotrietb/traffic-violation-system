/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tp.project.trafficviolationsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tp.project.trafficviolationsystem.domain.FineType;


public interface FineTypeRepository extends JpaRepository<FineType, Long>{
    
}
