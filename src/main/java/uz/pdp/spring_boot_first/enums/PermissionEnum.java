package uz.pdp.spring_boot_first.enums;

import lombok.Getter;

@Getter
public enum PermissionEnum {

    VIEW_DOCTOR(PageEnum.DOCTOR),
    ADD_DOCTOR(PageEnum.DOCTOR),
    EDIT_DOCTOR(PageEnum.DOCTOR),
    DELETE_DOCTOR(PageEnum.DOCTOR),

    VIEW_PATIENT(PageEnum.PATIENT),
    ADD_PATIENT(PageEnum.PATIENT),
    EDIT_PATIENT(PageEnum.PATIENT),
    DELETE_PATIENT(PageEnum.PATIENT),
    ;

    private final PageEnum page;


    PermissionEnum(PageEnum page) {
        this.page = page;
    }
}
