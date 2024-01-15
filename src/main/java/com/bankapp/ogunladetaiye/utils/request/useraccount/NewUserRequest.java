package com.bankapp.ogunladetaiye.utils.request.useraccount;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NewUserRequest {

    private String accountName;
    private String accountPassword;
}
