package com.suraj.TheBank.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /// ALTER TABLE account AUTO_INCREMENT = 100000000001;  (for initial value then increment)
    private long accountNumber;

    private double balance;
    private String name;
    private String email;
    private long phone;
}
