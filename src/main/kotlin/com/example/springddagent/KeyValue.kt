package com.example.springddagent

import org.springframework.data.jpa.repository.JpaRepository
import javax.persistence.*

@Entity
@Table(name = "key_values")
data class KeyValue(
    @Column(name = "key_", unique = true)
    val key: String,

    @Column(name = "value")
    val value: String
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
        protected set
}

interface KeyValueRepository : JpaRepository<KeyValue, Long>
