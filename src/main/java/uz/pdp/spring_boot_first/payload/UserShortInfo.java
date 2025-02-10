package uz.pdp.spring_boot_first.payload;

import java.util.UUID;

/**
 Created by: Mehrojbek
 DateTime: 07/02/25 20:49
 **/

public interface UserShortInfo {

    UUID getId();//id

    String getFirstName();//firstName

    String getLastName();

    String getCountry();

    String getCity();

}
