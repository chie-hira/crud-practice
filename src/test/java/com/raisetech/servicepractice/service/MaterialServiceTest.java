package com.raisetech.servicepractice.service;

import com.raisetech.servicepractice.entity.Material;
import com.raisetech.servicepractice.mapper.MaterialMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class MaterialServiceTest {
    @InjectMocks
    MaterialService materialService;

    @Mock
    MaterialMapper materialMapper;

    @Test
    public void すべての資料を要求したときすべての資料を取得できる() {
        doReturn(List.of(
                new Material(1, "shiryo1"),
                new Material(2, "shiryo2"),
                new Material(3, "shiryo3"),
                new Material(4, "shiryo4"),
                new Material(5, "shiryo5")
        )).when(materialMapper).findAll();
        List<Material> allMaterials = materialService.findAll();
        assertThat(allMaterials)
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
    public void 存在する資料IDを指定したとき正常に資料が渡されること() {
        doReturn(Optional.of(new Material(3, "shiryo3"))).when(materialMapper).findById(3);
        Material actual = materialService.findById(3);
        assertThat(actual).isEqualTo(new Material(3, "shiryo3"));
        verify(materialMapper, times(1)).findById(3);
    }

    @Test
    public void 存在しない資料名が渡されたとき正常に資料が登録されること() {
        Material material = new Material("shiryo6");
        doNothing().when(materialMapper).insert(material);
        Material actual = materialService.insert("shiryo6");
        assertThat(actual).isEqualTo(new Material(actual.getId(), "shiryo6"));
        verify(materialMapper, times(1)).insert(material);
    }
}
