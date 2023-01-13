package com.hopper;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * String determines the primary key's type. Can be changed to long, for example
 */
public interface ContentDatabase extends JpaRepository <Content, String>{


}
