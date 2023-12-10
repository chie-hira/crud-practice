package com.raisetech.servicepractice.mapper;

import com.raisetech.servicepractice.entity.Material;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MaterialMapperTest {
    @Autowired
    MaterialMapper materialMapper;

    @Test
    @Sql(
            scripts = {"classpath:/sqlannotation/delete-materials.sql","classpath:/sqlannotation/insert-materials.sql"},
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD
    )
    @Transactional
    void すべての資料が取得できること() {
        List<Material> materials = materialMapper.findAll();
        assertThat(materials)
                .hasSize(5)
                .contains(
                        new Material(1, "shiryo1"),
                        new Material(2, "shiryo2"),
                        new Material(3, "shiryo3"),
                        new Material(4, "shiryo4"),
                        new Material(5, "shiryo5")
                );
    }

    @Test
    void idから資料を取得できること() {
        int materialId = 2;
        Optional<Material> material = materialMapper.findById(materialId);
        assertThat(material)
                .isPresent()
                .hasValueSatisfying(m -> assertThat(m)
                        .isEqualTo(new Material(materialId, "shiryo2")));
    }

    @Test
    void 資料名から資料を取得できること() {
        String materialName = "shiryo3";
        Optional<Material> material = materialMapper.findByName(materialName);
        assertThat(material)
                .isPresent()
                .hasValueSatisfying(m -> assertThat(m)
                        .isEqualTo(new Material(3, "shiryo3")));
    }

    @Test
    void 資料を登録できること() {
        Material material = new Material("shiryo7");
        materialMapper.insert(material);
        int materialId = material.getId();

        List<Material> allMaterials = materialMapper.findAll();
        assertThat(allMaterials)
                .hasSize(7)
                .contains(
                        new Material(materialId, "shiryo7")
                );
    }
}
