package com.manuel.pokemonDemo;

import com.opencsv.bean.CsvBindByName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import javax.persistence.*;
import java.sql.Timestamp;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table (name = "pokemon")
public class Pokemon {
    //#,Name,Type 1,Type 2,Total,HP,Attack,Defense,Sp. Atk,Sp. Def,Speed,Generation,Legendary
    @Id
    @GeneratedValue
    @Column(updatable = false, nullable = false)
    Long id;
    @Column
    @CsvBindByName(column = "#")
    Long originalId;
    @Column
    @CsvBindByName(column = "name")
    String name;
    @Column
    @CsvBindByName(column = "Type 1")
    String type1;
    @Column
    @CsvBindByName(column = "Type 2")
    String type2;
    @Column
    @CsvBindByName(column = "Total")
    Integer total;
    @Column
    @CsvBindByName(column = "HP")
    Integer hp;
    @Column
    @CsvBindByName(column = "Attack")
    Integer attack;
    @Column
    @CsvBindByName(column = "Defense")
    Integer defense;
    @Column
    @CsvBindByName(column = "Sp. Atk")
    Integer spAttack;
    @Column
    @CsvBindByName(column = "Sp. Def")
    Integer spDefense;
    @Column
    @CsvBindByName(column = "speed")
    Long speed;
    @Column
    @CsvBindByName(column = "Generation")
    Integer generation;
    @Column
    @CsvBindByName(column = "Legendary")
    Boolean legendary;
    @CreationTimestamp
    @Column(updatable = false)
    Timestamp dateCreated;
    @UpdateTimestamp
    Timestamp lastModified;

}