package com.suraj.TheBank.dto;

/*
using simple java impl

    import lombok.AllArgsConstructor;
    import lombok.Getter;
    import lombok.NoArgsConstructor;
    import lombok.Setter;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public class AccountDto {
        private long accountNumber;
        private double balance;
        private String name;
        private String email;
        private long phone;
    }

*/

/// using record class(introduced in java17 & 17+)
public record AccountDto(long accountNumber, double balance, String name, String email, long phone) {
}