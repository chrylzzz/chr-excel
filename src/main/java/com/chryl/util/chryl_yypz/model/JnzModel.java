package com.chryl.util.chryl_yypz.model;

import lombok.*;

import java.util.Objects;

/**
 * Created by Chr.yl on 2025/7/10.
 *
 * @author Chr.yl
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class JnzModel {
    String shengfen_name;
    String shengfen_code;
    String jnc_code;
    String jnz_name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JnzModel jnzModel = (JnzModel) o;
        return Objects.equals(shengfen_name, jnzModel.shengfen_name) && Objects.equals(shengfen_code, jnzModel.shengfen_code) && Objects.equals(jnc_code, jnzModel.jnc_code) && Objects.equals(jnz_name, jnzModel.jnz_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shengfen_name, shengfen_code, jnc_code, jnz_name);
    }
}
