package com.raisetech.servicepractice.mapper;

import com.raisetech.servicepractice.entity.StoragePlace;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class StoragePlaceMapperTest {
    @Autowired
    StoragePlaceMapper storagePlaceMapper;

    @Test
    @Sql(scripts = {"classpath:/sqlannotation/delete-storage_places.sql","classpath:/sqlannotation/insert-storage_places.sql"},executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Transactional
    void すべての保管場所が取得できること() {
        List<StoragePlace> allStoragePlaces = storagePlaceMapper.findAll();
        assertThat(allStoragePlaces)
                .hasSize(5)
                .contains(
                        new StoragePlace(1, LocalDate.parse("2023-11-01"), "書庫1-1", 1, 1, "megu", "shiryo1"),
                        new StoragePlace(2, LocalDate.parse("2023-11-01"), "書庫2-1", 2, 2, "deji", "shiryo2"),
                        new StoragePlace(3, LocalDate.parse("2023-11-03"), "書庫2-1", 1, 3, "megu", "shiryo3"),
                        new StoragePlace(4, LocalDate.parse("2023-11-03"), "書庫1-1", 1, 4, "megu", "shiryo4"),
                        new StoragePlace(5, LocalDate.parse("2023-11-05"), "書庫1-2", 2, 5, "deji", "shiryo5")
                );
    }

    @Test
    @Sql(scripts = {"classpath:/sqlannotation/delete-storage_places.sql","classpath:/sqlannotation/insert-storage_places.sql"},executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Transactional
    void 資料idから保管場所情報を取得できること() {
        int materialId = 3;
        Optional<StoragePlace> storagePlace = storagePlaceMapper.findByMaterialId(materialId);
        assertThat(storagePlace)
                .isPresent()
                .hasValueSatisfying(s -> assertThat(s)
                .isEqualTo(new StoragePlace(3, LocalDate.parse("2023-11-03"), "書庫2-1", 1, 3)));
    }

    @Test
    @Sql(scripts = {"classpath:/sqlannotation/delete-storage_places.sql","classpath:/sqlannotation/insert-storage_places.sql"},executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Transactional
    void materialテーブルに存在する資料のうち保管していない資料を保管登録できること() {
        StoragePlace storagePlace = new StoragePlace(LocalDate.parse("2023-12-10"), "書庫2-1", 3, 6);
        storagePlaceMapper.insert(storagePlace);
        int storagePlaceId = storagePlace.getId();
        List<StoragePlace> allStoragePlaces = storagePlaceMapper.findAll();
        assertThat(allStoragePlaces)
                .hasSize(6)
                .contains(
                        new StoragePlace(storagePlaceId, LocalDate.parse("2023-12-10"), "書庫2-1", 3, 6, "mopu", "shiryo6")
                );
    }
}
