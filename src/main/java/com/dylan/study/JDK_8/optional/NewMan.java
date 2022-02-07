package com.dylan.study.JDK_8.optional;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

//注意：Optional 不能被序列化

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewMan {
    private String name;
    private Optional<Goddess> goddess=Optional.empty();

    private Goddess god;

    public Optional<Goddess> getGod(){
        return Optional.of(god);
    }

}
