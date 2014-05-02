/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tp.lotriet.domain;

import javax.persistence.Embeddable;

/**
 *
 * @author Brandon1
 */
@Embeddable
public class violation {
    private Long violation_code;
    private String description;

    public Long getViolation_code() {
        return violation_code;
    }

    public void setViolation_code(Long violation_code) {
        this.violation_code = violation_code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
}
