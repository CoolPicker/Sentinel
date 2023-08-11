/*
 * Copyright 1999-2018 Alibaba Group Holding Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alibaba.csp.sentinel.slotchain;

/**
 * The builder for processor slot chain.
 * 在Java开发中，SPI（Service Provider Interface）是一种机制，允许第三方提供实现特定的服务，而这些服务由Java平台的核心组件或应用程序调用。
 * SlotChainBuilder - 作为SPI接口，使得Slot Chain具有拓展的能力。
 * 通过实现 SlotsChainBuilder 接口加入自定义的 slot 并自定义编排各个 slot 之间的顺序，从而可以给 Sentinel 添加自定义的功能。
 *
 * 那SlotChain是在哪创建的呢？
 * 是在 CtSph.lookProcessChain() 方法中创建的，并且该方法会根据当前请求的资源先去一个静态的HashMap中获取，
 * 如果获取不到才会创建，创建后会保存到HashMap中。这就意味着，同一个资源会全局共享一个SlotChain。
 * @author qinan.qn
 * @author leyou
 * @author Eric Zhao
 */
public interface SlotChainBuilder {

    /**
     * Build the processor slot chain.
     *
     * @return a processor slot that chain some slots together
     */
    ProcessorSlotChain build();
}
